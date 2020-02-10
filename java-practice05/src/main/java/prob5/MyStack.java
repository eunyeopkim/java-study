package prob5;

public class MyStack<T> {

	private int top;
	private T[] buffer;

	@SuppressWarnings("unchecked")
	public MyStack(int size) {
		top = -1;
		buffer = (T[]) new Object[size];	// 배열은 T 지원 x (buffer = new T[size] x)
	}

	public void push(T t) {
		if (isFull()) {
			doubleSize();
		}
		// buffer[++top] = string 같은말
		top++;
		buffer[top] = t;

	}

	public T pop() throws MyStackException {

		if (isEmpty()) {
			throw new MyStackException();
		} else {

			T temp = buffer[top];
			// buffer[top--] = null; 같은말
			buffer[top] = null;
			top--;
			return temp;

		}

	}

	public void doubleSize() {
		T[] newBuffer = (T[]) new Object[buffer.length + 5]; // new배열로 옮겨주는 작업 필요, T배열로 옮김
		for (int i = 0; i < buffer.length; i++) {
			newBuffer[i] = buffer[i];
		}
		this.buffer = newBuffer;
	}

	public boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		return top == buffer.length - 1; // buffer.length == top + 1 같은말
	}

}