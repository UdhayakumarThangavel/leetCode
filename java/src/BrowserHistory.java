import java.util.ArrayList;
import java.util.List;

class BrowserHistory {
    List<String> history = new ArrayList<>();
    int current_position = 0;
    boolean isForwardValid = false;
    public BrowserHistory(String homepage) {
        this.history.add(homepage);
        current_position = 1;
        isForwardValid= false;
    }

    public void visit(String url) {
        this.history.add(url);
        current_position = history.size();
        isForwardValid = false;
    }

    public String back(int steps) {
        if(current_position > steps){
            current_position= current_position - (steps);
            String url =history.get(current_position-1);
            history.add(url);
            isForwardValid = true;
            return url;
        }
        return history.get(current_position-1);
    }

    public String forward(int steps) {
        if(isForwardValid && history.size()>(current_position+steps)){
            current_position= current_position + (steps);
            String url = history.get(current_position-1);
            history.add(url);
            return url;
        }
        return history.get(current_position-1);
    }

}