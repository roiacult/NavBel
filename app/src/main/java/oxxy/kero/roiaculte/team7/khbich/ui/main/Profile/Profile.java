package oxxy.kero.roiaculte.team7.khbich.ui.main.Profile;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;
import oxxy.kero.roiaculte.team7.khbich.R;
import oxxy.kero.roiaculte.team7.khbich.Utils.ImageUtil;
import oxxy.kero.roiaculte.team7.khbich.Utils.TextUtils;
import oxxy.kero.roiaculte.team7.khbich.base.BaseActivity;
import oxxy.kero.roiaculte.team7.khbich.base.BaseFragment;
import oxxy.kero.roiaculte.team7.khbich.databinding.ProfileBinding;
import oxxy.kero.roiaculte.team7.khbich.databinding.ProfileCardBinding;
import oxxy.kero.roiaculte.team7.khbich.model.models.Test;
import oxxy.kero.roiaculte.team7.khbich.ui.UserView;
import oxxy.kero.roiaculte.team7.khbich.ui.main.Main;
import oxxy.kero.roiaculte.team7.khbich.ui.main.MainViewModel;

import static oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dataSources.Authentification.TAG;

public class Profile extends BaseFragment implements ContractProfile.VIEW {

    private ProfileBinding binding;
    @Inject ContractProfile.PRESENTER presenter;
    private TestAdapter adapter;
    private MainViewModel viewModel;
    @Inject SharedPreferences preferences;

    private SortedList.Callback<Test> testCallback = new SortedList.Callback<Test>() {
        @Override
        public int compare(Test o1, Test o2) {
            return 0;
        }

        @Override
        public void onChanged(int position, int count) {
            adapter.notifyItemRangeChanged(position,count);
        }

        @Override
        public boolean areContentsTheSame(Test oldItem, Test newItem) {
            return oldItem.getName().equals(newItem.getName());
        }

        @Override
        public boolean areItemsTheSame(Test item1, Test item2) {
            return item1.Id == item2.Id;
        }

        @Override
        public void onInserted(int position, int count) {
            adapter.notifyItemRangeInserted(position,count);
        }

        @Override
        public void onRemoved(int position, int count) {
        }

        @Override
        public void onMoved(int fromPosition, int toPosition) {

        }
    } ;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getComponent().inject(this) ;

        binding = DataBindingUtil.inflate(inflater,R.layout.profile,container,false);
        viewModel = ViewModelProviders.of(getBaseActivity()).get(MainViewModel.class);
        presenter.onAttach(this);
        adapter = new TestAdapter();

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        ((LinearLayoutManager) manager).setOrientation(RecyclerView.VERTICAL);

        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(manager);


        return binding.getRoot();
    }

    @Override
    public void setName(String name) {
        binding.name.setText(name);
    }

    @Override
    public void setPoint(String point) {
        binding.ponints.setText(point);
    }

    @Override
    public void setLevel(String level) {
        binding.level.setText(level);
    }

    @Override
    public void setTests(String tests) {
        binding.tests.setText(tests);
    }

    class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestHolder>{

        private SortedList<Test> listOfTests = new SortedList<>(Test.class,testCallback);

        @NonNull
        @Override
        public TestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater =LayoutInflater.from(parent.getContext());
            ProfileCardBinding binding = DataBindingUtil.inflate(inflater,R.layout.profile_card,parent,false);

            return new TestHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull TestHolder holder, int position) {
            holder.upDateCard(listOfTests.get(position));
        }

        @Override
        public int getItemCount() {
            if(listOfTests == null) return 0;
            return listOfTests.size();
        }

        class TestHolder extends RecyclerView.ViewHolder{

            private ProfileCardBinding binding;

            public TestHolder(@NonNull ProfileCardBinding itemView) {
                super(itemView.getRoot());
                binding = itemView;
            }

            public void upDateCard(Test test){
                binding.name.setText(test.getName());

                String str=preferences.getString("oxxy.kero.roiaculte.team7.khbich.QSOLVED","");
                int nb = TextUtils.getQuestionById(str, test.getId());//this will have the number of the question solved
                binding.numbreOfQuestionsSolved.setText("numbre of questions solved : "+String.valueOf(nb));
                binding.note.setText(String.valueOf(test.getNumberQuestion()));
                binding.totalnote.setText(String.valueOf(test.getPoints()));
            }
        }
    }

    @Override
    public void notifyAdapter() {
        if (adapter == null) {
            adapter = new TestAdapter();
            binding.recycler.setAdapter(adapter);
        }
        if (viewModel.getTests() == null) showMessage("list in view est vide");

        adapter.listOfTests.addAll(viewModel.getTests());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setImage(Uri path) {
        Log.d(TAG, "setImage: "+path.getPath());
//        binding.circleImageView.setImageBitmap(MediaStore.Images.Media..decodeFile(path));
        binding.circleImageView.setImageURI(path);
        Picasso.get().load(path).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                binding.circleImageView.setImageBitmap(bitmap);
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });
    }
}
