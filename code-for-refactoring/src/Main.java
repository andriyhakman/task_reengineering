public class Main {
    public static void main(String[] args) {
        WorkerHelper workerHelper = new WorkerHelper();

        workerHelper.addFullTimeWorker("john",1200);
        workerHelper.addFullTimeWorker("paul",1500);

        workerHelper.addPartTimeWorker("george", 8, 100);
        workerHelper.addPartTimeWorker("ringo", 8, 111);

        // Total salary
        System.out.println(workerHelper.getTotalSalary());
        System.out.println(workerHelper.getTotalAvg());
        System.out.println(workerHelper.getWorkersMaxSalary());
        System.out.println(workerHelper.getWorkersMinSalary());
    }
}