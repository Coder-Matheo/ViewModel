package rob.myappcompany.viewmodelarchitect;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ScoreViewModel extends ViewModel {

    /*private Integer score;

    public Integer getScore(){
        if (score == null){
            score = new Integer(0);

        }
        return score;
    }
*/

    private MutableLiveData<Integer> score;

    public MutableLiveData<Integer> getScore(){
        if (score == null){
            score = new MutableLiveData<>();
            score.setValue(0);
            //score.postValue(0);//This is called from a worker thread
        }
        return score;
    }

    public void addScore(){
        if (score.getValue() != null){
            score.setValue(score.getValue() + 1);
        }

       /* if (score == null){
            score = 0;
        }
        score += 1;*/
    }
    public  void resetScore(){
        score.setValue(0);
        //score = 0;
    }
}
