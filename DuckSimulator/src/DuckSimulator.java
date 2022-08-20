public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator() ;
        simulator.simulation();
        simulator.simulateDecorator1();
        simulator.simulateDecorator2();
        simulator.simulateComposite1();
        simulator.simulateAbstractFactory();
        simulator.simulateComposite2() ;
    }

    void simulation(){
        Quackable mallardDuck = new QuackCounter(new QuackEcho(new MallardDuck())) ;
        Quackable redheadDuck = new QuackCounter(new QuackEcho(new RedHeadDuck())) ;
        Quackable rubberDuck = new QuackCounter(new QuackEcho(new RubberDuck())) ;
        Quackable gooseDuck = new QuackCounter(new QuackEcho(new GooseAdapter(new Goose()))) ;
        Quackable pigeon = new QuackCounter(new QuackEcho(new PigeonAdapter(new Pigeon()))) ;

        System.out.println("\nDuck Simulator: With Goose Adapter");

        simulation(mallardDuck);
        simulation(redheadDuck);
        simulation(rubberDuck);
        simulation(gooseDuck);
        simulation(pigeon);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
    }
    void simulation(Quackable duck){
        duck.quack();
    }

    private void simulateDecorator1() {
        Quackable mallardDuck = new QuackCounter(new MallardDuck());
        Quackable redHeadDuck = new QuackCounter(new RedHeadDuck());
        Quackable rubberDuck = new QuackCounter(new RubberDuck());
        Quackable gooseAdapter = new GooseAdapter(new Goose());
        Quackable pigeonAdapter = new PigeonAdapter(new Pigeon());
        Quackable mallardDecorator = new QuackCounter(new QuackEcho(new MallardDuck()));

        System.out.println("\nDuck Simulator: With Decorator");

        simulation(mallardDuck);
        simulation(redHeadDuck);
        simulation(rubberDuck);
        simulation(gooseAdapter);
        simulation(pigeonAdapter);
        simulation(mallardDecorator);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times.");
    }

    private void simulateDecorator2() {
        Quackable mallardDuck = new QuackCounter(new MallardDuck());
        Quackable redHeadDuck = new QuackCounter(new RedHeadDuck());
        Quackable rubberDuck = new QuackCounter(new RubberDuck());
        Quackable gooseAdapter = new GooseAdapter(new Goose());
        Quackable pigeonAdapter = new PigeonAdapter(new Pigeon());
        Quackable redHeadDecorator = new QuackEcho(new QuackCounter(new RedHeadDuck()));

        System.out.println("\nDuck Simulator With Decorator");

        simulation(mallardDuck);
        simulation(redHeadDuck);
        simulation(rubberDuck);
        simulation(gooseAdapter);
        simulation(pigeonAdapter);
        simulation(redHeadDecorator);
        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times.");
    }

    private void simulateAbstractFactory() {
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory countingDuckFactory = new CountDuckFactory();
        AbstractDuckFactory countAndEchoDuckFactory = new CountAndEchoFactory();

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redHeadDuck = countingDuckFactory.createRedHeadDuck();
        Quackable rubberDuck = countAndEchoDuckFactory.createRubberDuck();

        System.out.println("\nDuck Simulator: With Abstract Factory");

        simulation(mallardDuck);
        simulation(redHeadDuck);
        simulation(rubberDuck);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times.");
    }

    private void simulateComposite1() {
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory countingDuckFactory = new CountDuckFactory();

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redHeadDuck = duckFactory.createRedHeadDuck();
        Quackable rubberDuck = countingDuckFactory.createRubberDuck();

        Flock flock = new Flock();
        flock.add(mallardDuck);
        flock.add(redHeadDuck);
        flock.add(rubberDuck);

        flock.quack();
    }

    private void simulateComposite2() {
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory countingDuckFactory = new CountDuckFactory();

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redHeadDuck = duckFactory.createRedHeadDuck();
        Quackable rubberDuck = countingDuckFactory.createRubberDuck();

        LeaderFlock flock = new LeaderFlock();
        flock.add(mallardDuck);
        flock.add(redHeadDuck);
        flock.add(rubberDuck);

        flock.quack();
    }

}
