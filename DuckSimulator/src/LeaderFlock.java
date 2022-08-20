public class LeaderFlock extends Flock{
    @Override
    public void quack() {
        for (int i = 0; i < quackables.size(); i++) {
            if(i == 0){
                quackables.get(i).quack();
                quackables.get(i).quack();
                quackables.get(i).quack();
            }
            else{
                quackables.get(i).quack();
            }
        }
    }
}
