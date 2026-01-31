import java.util.Arrays;

class kQueues {
    int[] arr;
    int[] front;
    int[] rear;
    int[] next;
    int free;
    int n, k;

    kQueues(int n, int k) {
        front = new int[k];
        rear = new int[k];
        next = new int[n];
        arr = new int[n];
        Arrays.fill(front, -1);
        Arrays.fill(rear, -1);
        for (int i = 0; i < n; i++) {
            next[i] = i + 1;
        }
        free = 0;
        next[n - 1] = -1;
        this.n = n;
        this.k = k;
    }

    void enqueue(int x, int i) {
        if (free == -1)
            return;
        int idx = free;
        free = next[idx];
        if (isEmpty(i))
            front[i] = idx;
        else {
            next[rear[i]] = idx;
        }
        next[idx] = -1;
        rear[i] = idx;
        arr[idx] = x;

    }

    int dequeue(int i) {
        if (isEmpty(i))
            return -1;
        int currIndex = front[i];
        front[i] = next[currIndex];
        if (front[i] == -1) {
            rear[i] = -1;
        }
        next[currIndex] = free;
        free = currIndex;
        return arr[currIndex];
    }

    boolean isEmpty(int i) {
        return front[i] == -1;
    }

    boolean isFull() {
        return free == -1;
    }
}

// APPROACH
// Initialize arrays
// front --- stores the front indexes of queues else hold -1
// rear --- stores the rear indexes of queues else hold -1
// arr ---  stores the values in the queues
// next --- stores the next occupied index  for occupied indexes
//          Stores the next free index for empty slots
// free --- Index of the first non occupied slot
// Initialize next[] with next[i]=i+1 and free=0
// Enqueue(int x,int i): Add the element to the index at free and update rear and next[rear]
//                       take the index of free and move free to next free Index i.e free=next[free]
// DeQueue(int x):if queue is empty then return -1;
//                 return the value at index of front of queue
//                 update free to the removed index and make next[removed]=free 
// isEmpty(int i): return front==-1;
// isFull(): return free=-1;


// COMPLEXITIES:
// TIME : O(1) for every operation
// SPACE : O(n+k) fro storing values and indexes of front and rear