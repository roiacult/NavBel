package oxxy.kero.roiaculte.team7.khbich.ui.main.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

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
import oxxy.kero.roiaculte.team7.khbich.Utils.QuestionUtil;
import oxxy.kero.roiaculte.team7.khbich.base.BaseActivity;
import oxxy.kero.roiaculte.team7.khbich.databinding.QuestionFillGapsBinding;
import oxxy.kero.roiaculte.team7.khbich.databinding.QuestionQcmBinding;
import oxxy.kero.roiaculte.team7.khbich.databinding.TestActivityBinding;
import oxxy.kero.roiaculte.team7.khbich.model.models.Question;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.DataFlowRepository;

public class Test extends BaseActivity {

    private TestActivityBinding binding;
    private TestViewModel viewModel;
    @Inject DataFlowRepository dataFlow;

    private QuestionAdapterQcm adapterQcm;
    private QuestionAdapterFillGaps adapterFillGaps;
    private SortedList.Callback<Question> callback= new SortedList.Callback<Question>() {
        @Override
        public int compare(Question o1, Question o2) {
            return 0;
        }

        @Override
        public void onChanged(int position, int count) {
            if (adapterQcm != null)
            adapterQcm.notifyItemRangeChanged(position,count);

            if (adapterFillGaps != null)
                adapterFillGaps.notifyItemRangeChanged(position,count);

        }

        @Override
        public boolean areContentsTheSame(Question oldItem, Question newItem) {
            return oldItem.getQuestion().equals(newItem.getQuestion());
        }

        @Override
        public boolean areItemsTheSame(Question item1, Question item2) {
            return item1.getId()==item2.getId();
        }

        @Override
        public void onInserted(int position, int count) {
            if (adapterQcm != null)
            adapterQcm.notifyItemRangeInserted(position,count);

            if (adapterFillGaps != null)
                adapterFillGaps.notifyItemRangeChanged(position,count);

        }

        @Override
        public void onRemoved(int position, int count) {
            if (adapterQcm != null)
            adapterQcm.notifyItemRangeRemoved(position,count);
        }

        @Override
        public void onMoved(int fromPosition, int toPosition) {
            if (adapterQcm != null)
            adapterQcm.notifyItemMoved(fromPosition,toPosition);

            if (adapterFillGaps != null)
                adapterFillGaps.notifyItemRangeChanged(fromPosition,toPosition);

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.test_activity);
        viewModel = ViewModelProviders.of(this).get(TestViewModel.class);
        long id = getIntent().getLongExtra(Home.TEST_ID,-1);
        viewModel.setTestId(id);

        adapterQcm = new QuestionAdapterQcm();
        adapterFillGaps = new QuestionAdapterFillGaps();

        if (viewModel.getQuestionsView()==null){
            dataFlow.getQuestionFromTest(new QuestionObserver(),id);
        }else{
            adapterFillGaps.questionSortedList.addAll(viewModel.getQuestionsView().questionsFillGaps);
            adapterQcm.questionSortedList.addAll(viewModel.getQuestionsView().questionsQcm);
            //TODO set adapterAnswer
        }

        LinearLayoutManager manager = new LinearLayoutManager(this);

        binding.qcm.setAdapter(adapterQcm);
        binding.qcm.setLayoutManager(manager);
        binding.qcm.setHasFixedSize(true);

        binding.fillGaps.setAdapter(adapterFillGaps);
        binding.fillGaps.setLayoutManager(manager);
        binding.fillGaps.setHasFixedSize(true);


        //TODO same thing with adapterAnswer

    }




    private class QuestionObserver extends DisposableObserver<List<Question>> {

        @Override
        public void onNext(List<Question> questions) {

            QuestionsView questionsView = QuestionUtil.convert(questions);
            viewModel.setQuestionsView(questionsView);

            adapterFillGaps.questionSortedList.addAll(questionsView.questionsFillGaps);
            adapterQcm.questionSortedList.addAll(questionsView.questionsQcm);
            //TODO set adapterAnswer

            adapterQcm.notifyDataSetChanged();
            adapterFillGaps.notifyDataSetChanged();
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    }




    class QuestionAdapterQcm extends RecyclerView.Adapter<QuestionAdapterQcm.QuestionHolderQcm>{


        SortedList<Question> questionSortedList = new SortedList<>(Question.class,callback);

        @NonNull
        @Override
        public QuestionHolderQcm onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());

            QuestionQcmBinding binding = DataBindingUtil.inflate(inflater,R.layout.question_qcm,parent,false);

            return new QuestionHolderQcm(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull QuestionHolderQcm holder, int position) {
            holder.updateUi(questionSortedList.get(position));
        }

        @Override
        public int getItemCount() {
            return questionSortedList.size();
        }

        class QuestionHolderQcm extends RecyclerView.ViewHolder{

            private QuestionQcmBinding binding;

            public QuestionHolderQcm(@NonNull QuestionQcmBinding itemView) {
                super(itemView.getRoot());
                binding =  itemView;
            }

            public void updateUi(Question question){
//                Picasso.get().load(question.getImageUrl()).into(binding.image);
//                binding.q1.set
            }
        }
    }



    class QuestionAdapterFillGaps extends RecyclerView.Adapter<QuestionAdapterFillGaps.QuestionHolderFillGaps>{


        SortedList<Question> questionSortedList = new SortedList<>(Question.class,callback);

        @NonNull
        @Override
        public QuestionHolderFillGaps onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());




            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull QuestionHolderFillGaps holder, int position) {
            holder.updateUi(questionSortedList.get(position));
        }

        @Override
        public int getItemCount() {
            return questionSortedList.size();
        }

        class QuestionHolderFillGaps extends RecyclerView.ViewHolder{

            QuestionFillGapsBinding binding;

            public QuestionHolderFillGaps(@NonNull QuestionFillGapsBinding itemView) {
                super(itemView.getRoot());
                binding = itemView;
            }

            public void updateUi(Question question){

            }
        }
    }


}
