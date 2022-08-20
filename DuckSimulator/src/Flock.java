import java.util.ArrayList;

public class Flock implements Quackable {
    ArrayList<Quackable> quackables = new ArrayList<>() ;

    public void add(Quackable quackable) {
        quackables.add(quackable) ;
    }

    @Override
    public void quack() {
        for (Quackable q:quackables) {
            q.quack();
        }
    }
}
