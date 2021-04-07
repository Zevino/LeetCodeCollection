package CircularQueue;

public class CircularQueue {
    class MyCircularQueue {

        // 存储数据的数组
        private int[] data;
        // 头部指针
        private int head;
        // 尾部指针
        private int tail;
        // 数组的长度
        private int size;

        /** Initialize your data structure here. Set the size of the queue to be k. */
        /* 初始化整个循环队列的数据结构， 并且设置队列的长度为k  */
        public MyCircularQueue(int k) {
            data = new int[k];
            head = -1;
            tail = -1;
            size = k;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        /* 插入一个元素到循环队列当中。 如果操作成功就返回true */
        public boolean enQueue(int value) {
            /*  如果队列满了，就返回false */
            if (isFull() == true) {
                return false;
            }
            /* 如果队列的元素就设置头指针为0 进行初始化 */
            if (isEmpty() == true) {
                head = 0;
            }

            /* 循环队列的灵魂所在(核心处理步骤) */
            tail = (tail + 1) % size;
            /* 插值操作 */
            data[tail] = value;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if (isEmpty() == true) {
                return false;
            }
            if (head == tail) {
                head = -1;
                tail = -1;
                return true;
            }
            head = (head + 1) % size;
            return true;
        }

        /*
        * 在操作队列的时候需要用到的方法
        * create By ZeeVN
        * */

        /** Get the front item from the queue. */
        public int Front() {
            if (isEmpty() == true) {
                return -1;
            }
            return data[head];
        }

        /** Get the last item from the queue. */
        public int Rear() {
            if (isEmpty() == true) {
                return -1;
            }
            return data[tail];
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return head == -1;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return ((tail + 1) % size) == head;
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
}
