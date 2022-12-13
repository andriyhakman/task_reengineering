import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WorkerHelper {
    private List<FullTimeWorker> fullTimeWorkers = new ArrayList<>();
    private List<PartTimeWorker> partTimeWorkers = new ArrayList<>();

    public void addFullTimeWorker(String name, int salary) {
        this.fullTimeWorkers.add(new FullTimeWorker(name,salary));
    }

    public void addPartTimeWorker(String name, int rate, int hours) {
        this.partTimeWorkers.add(new PartTimeWorker(name, rate, hours));
    }

    public int getTotalSalary() {
        return this.getFullTimeWorkersTotalSalary() + this.getPartTimeWorkersTotalSalary();
    }

    public float getTotalAvg() {
        if (this.getTotalSalary() > 0) {
            return this.getTotalSalary() / (this.fullTimeWorkers.size() + this.partTimeWorkers.size());
        }

        return 0;
    }

    public float getWorkersMinSalary() {
        List<Integer> workersSalaries = new ArrayList<>();

        for (int i = 0; i < this.fullTimeWorkers.size(); i++) {
            workersSalaries.add(this.fullTimeWorkers.get(i).getSalary());
        }
        for (int i = 0; i < this.partTimeWorkers.size(); i++) {
            workersSalaries.add(this.partTimeWorkers.get(i).getRate() * this.partTimeWorkers.get(i).getHours());
        }

        if (workersSalaries.size() == 0) {
            return 0;
        }

        workersSalaries.sort(Comparator.comparingInt(Integer::intValue));

        return workersSalaries.get(0);
    }

    public float getWorkersMaxSalary() {
        List<Integer> workersSalaries = new ArrayList<>();

        for (int i = 0; i < this.fullTimeWorkers.size(); i++) {
            workersSalaries.add(this.fullTimeWorkers.get(i).getSalary());
        }
        for (int i = 0; i < this.partTimeWorkers.size(); i++) {
            workersSalaries.add(this.partTimeWorkers.get(i).getRate() * this.partTimeWorkers.get(i).getHours());
        }

        if (workersSalaries.size() == 0) {
            return 0;
        }

        workersSalaries.sort(Comparator.reverseOrder());

        return workersSalaries.get(0);
    }

    private int getFullTimeWorkersTotalSalary() {
        if (fullTimeWorkers.size() == 0) {
            return 0;
        }

        int total = 0;
        for (int i = 0; i < this.fullTimeWorkers.size(); i++) {
            total += this.fullTimeWorkers.get(i).getSalary();
        }

        return total;
    }

    private int getPartTimeWorkersTotalSalary() {
        if (partTimeWorkers.size() == 0) {
            return 0;
        }

        int total = 0;
        for (int i = 0; i < this.partTimeWorkers.size(); i++) {
            total += this.partTimeWorkers.get(i).getRate() * this.partTimeWorkers.get(i).getHours();
        }

        return total;
    }
}
