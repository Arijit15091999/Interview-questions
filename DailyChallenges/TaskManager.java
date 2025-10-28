import java.util.*;

public class TaskManager {
    private List<List<Integer>> tasks;
    private PriorityQueue<Task> pq;
    private Map<Integer, Integer> taskPriorityMap;
    private Map<Integer, Integer> taskUserMap;

    public TaskManager(List<List<Integer>> tasks) {
        this.tasks = tasks;
        init();
    }

    public void add(int userId, int taskId, int priority) {
        this.taskPriorityMap.put(taskId, priority);
        this.taskUserMap.put(taskId, userId);
        this.pq.offer(new Task(taskId, priority));
    }

    public void edit(int taskId, int newPriority) {
        this.taskPriorityMap.put(taskId, newPriority);
        Task task = new Task(taskId, newPriority);
        this.pq.offer(task);
    }

    public void rmv(int taskId) {
        this.taskUserMap.remove(taskId);
        this.taskPriorityMap.remove(taskId);
    }

    public int execTop() {
        Task task = this.pq.peek();

        // if this task is not old and not removed

        while(
                !pq.isEmpty() &&
                (
                        !this.taskPriorityMap.containsKey(task.taskId) ||
                        task.taskPriority != this.taskPriorityMap.get(task.taskId)
                )
        ){
            pq.poll();
            task = pq.peek();
        }
        if(task == null) {
            return -1;
        }
        int userId = this.taskUserMap.get(task.taskId);
        this.taskPriorityMap.remove(task.taskId);
        this.taskUserMap.remove(task.taskId);
        return userId;
    }

    private void init() {
        this.taskPriorityMap = new HashMap<>();
        this.pq = new PriorityQueue<>();
        this.taskUserMap = new HashMap<>();

        for(List<Integer> task : this.tasks) {
            int userId = task.get(0);
            int taskId = task.get(1);
            int taskPriority = task.get(2);
            taskPriorityMap.put(taskId, taskPriority);
            taskUserMap.put(taskId, userId);
            this.pq.offer(new Task(taskId, taskPriority));
        }
    }

    private class Task implements Comparable<Task>{
        public int taskId;
        public int taskPriority;
        public Task(int taskId, int taskPriority) {
            this.taskId = taskId;
            this.taskPriority = taskPriority;
        }
        @Override
        public int compareTo(Task other) {
            if(this.taskPriority == other.taskPriority) {
                return -1 * (this.taskId - other.taskId);
            }
            return -1 * (this.taskPriority - other.taskPriority);
        }
    }
}