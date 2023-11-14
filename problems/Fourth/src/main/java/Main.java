public class Main {
    public static void main(String[] args) {
        ClassInfo classInfo = new ClassInfo("classes.Human");
        classInfo.showClassInfo();
        classInfo = new ClassInfo("classes.Lecturer");
        classInfo.showClassInfo();
        classInfo = new ClassInfo("classes.Teacher");
        classInfo.showClassInfo();
    }
}