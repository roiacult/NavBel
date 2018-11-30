package oxxy.kero.roiaculte.team7.khbich.ui.main.Home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;
import io.reactivex.observers.DisposableObserver;
import oxxy.kero.roiaculte.team7.khbich.R;
import oxxy.kero.roiaculte.team7.khbich.base.BaseFragment;
import oxxy.kero.roiaculte.team7.khbich.databinding.MainHomeBinding;
import oxxy.kero.roiaculte.team7.khbich.databinding.MainMainCardBinding;
import oxxy.kero.roiaculte.team7.khbich.model.models.Test;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.DataFlowRepository;
import oxxy.kero.roiaculte.team7.khbich.ui.main.MainViewModel;

public class Home extends BaseFragment {


    public static String TEST_ID= "test_id";

    private MainHomeBinding binding;
    private TestAdapter adapter;
    private MainViewModel viewModel;
    private AlertDialog alertDialog;
     @Inject
     DataFlowRepository dataFlowRepository;

    private SortedList.Callback<Test> callback = new SortedList.Callback<Test>() {
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
            return item1.getId()==item2.getId();
        }

        @Override
        public void onInserted(int position, int count) {
            adapter.notifyItemRangeInserted(position,count);
        }

        @Override
        public void onRemoved(int position, int count) {
            adapter.notifyItemRangeRemoved(position,count);
        }

        @Override
        public void onMoved(int fromPosition, int toPosition) {
            adapter.notifyItemMoved(fromPosition,toPosition);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.main_home,container,false);
        getComponent().inject(this);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        if (adapter == null) adapter = new TestAdapter();
        if (viewModel.getTests() != null)adapter.testSortedList.addAll(viewModel.getTests());
        else dataFlowRepository.getAllTests(new TestObserver<Test>());
        binding.tests.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.VERTICAL);
        binding.tests.setLayoutManager(manager);
        binding.tests.setHasFixedSize(true);

        return binding.getRoot();
    }


    class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestHolder>{

        private SortedList<Test> testSortedList = new SortedList<>(Test.class,callback);
        @NonNull
        @Override
        public TestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            MainMainCardBinding binding = DataBindingUtil.inflate(inflater,R.layout.main_main_card,parent,false);

            return new TestHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull TestHolder holder, int position) {
            holder.upaDateUi(testSortedList.get(position));
        }

        @Override
        public int getItemCount() {
            return testSortedList.size();
        }

        class TestHolder extends RecyclerView.ViewHolder{

            private MainMainCardBinding binding;

            public TestHolder(@NonNull MainMainCardBinding itemView) {
                super(itemView.getRoot());
                binding = itemView;
            }

            public void upaDateUi(final Test test){
                Uri uri = Uri.parse(test.getImageUrl());
                binding.imageView.setImageURI(uri);
                binding.textView.setText(test.getName());
                binding.textView3.setText(test.getDescription());
                binding.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //TODO start testActivity
                        Intent intent = new Intent(getContext(), Test.class);
                        intent.putExtra(TEST_ID,test.getId());
                    }
                });
                binding.button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setTitle("Detailles");
                        builder.setMessage(
                                test.getName()+"\n"
                                +test.getDescription() +"\n"
                                +"numbre of question "+String.valueOf(test.getNumberQuestion())
                                +"total points "+test.getPoints()
                                +"Year --> "+test.getYear()
                        );

                        builder.setPositiveButton("close", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                alertDialog.dismiss();
                            }
                        });
                        alertDialog = builder.create();
                        alertDialog.show();
                    }
                });
            }
        }
    }

    private class TestObserver<T> extends DisposableObserver<List<Test>> {

        @Override
        public void onNext(List<Test> tests) {
            viewModel.setTests(tests);
            adapter.testSortedList.addAll(tests);
            adapter.notifyDataSetChanged();
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    }
}
