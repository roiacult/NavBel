package oxxy.kero.roiaculte.team7.khbich.ui.main.Profile;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;
import oxxy.kero.roiaculte.team7.khbich.R;
import oxxy.kero.roiaculte.team7.khbich.base.BaseActivity;
import oxxy.kero.roiaculte.team7.khbich.base.BaseFragment;
import oxxy.kero.roiaculte.team7.khbich.databinding.ProfileBinding;
import oxxy.kero.roiaculte.team7.khbich.databinding.ProfileCardBinding;
import oxxy.kero.roiaculte.team7.khbich.model.models.Test;
import oxxy.kero.roiaculte.team7.khbich.ui.UserView;

public class Profile extends BaseFragment implements ContractProfile.VIEW {

    private ProfileBinding binding;
    @Inject ContractProfile.PRESENTER presenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getComponent().inject(this) ;

        binding = DataBindingUtil.inflate(inflater,R.layout.profile,container,false);
        presenter.onAttach(this);
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
        binding.qsolved.setText(tests);
    }

    class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestHolder>{

        private SortedList<Test> listOfTests;

        @NonNull
        @Override
        public TestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater =LayoutInflater.from(parent.getContext());
            ProfileCardBinding binding = DataBindingUtil.inflate(inflater,R.layout.profile_card,parent,false);

            return new TestHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull TestHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        class TestHolder extends RecyclerView.ViewHolder{

            private ProfileCardBinding binding;

            public TestHolder(@NonNull ProfileCardBinding itemView) {
                super(itemView.getRoot());
                binding = itemView;
            }

            public void upDateCard(Test test){

            }
        }
    }
}
