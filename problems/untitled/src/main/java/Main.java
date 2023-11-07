public class Main {
    public static void main(String[] args) {
        ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();
        while (rootGroup.getParent() != null) {
            rootGroup = rootGroup.getParent();
        }

        ThreadHandler threadHandler = new ThreadHandler();
        threadHandler.printThreadsInfo(rootGroup);
    }
}