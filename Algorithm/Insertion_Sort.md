## Insertion Sort
```Java
public class Insertionsort {

	public static void sort(int[] array) {

		for(int i = 1; i < array.length; i++) {
			int flag = array[i];
			for(int j = i - 1; j >= 0; j--) {
				if(flag > array[j]) {
					array[j+1] = flag;
					break;
				}
				array[j+1] = array[j];
				array[j] = flag;
			}
		}
	}

	public static int[] generateIntArray(int size) {
		//how to shuffle
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = i + 1;
		}
		shuffle(array);
		return array;
	}

	public static boolean isSorted(int[] array) {
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i] > array[i+1]) {
				return false;
			}
		}
		return true;
	}

	public static void shuffle(int[] array) {
		Random r = new Random();
		for (int i = array.length - 1; i > 0; i--) {
			swap(array, i, r.nextInt(i + 1));
		}
	}

	public static void printArray(int[] array) {
		System.out.print("[");
		for (int i: array) {
			System.out.printf(i + ", ");
		}
		System.out.println("]");
	}

	//swap two elements of indices
	public static void swap(int[] array, int idx1, int idx2) {
		int temp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			int[] arr = generateIntArray(20);
			printArray(arr);

			sort(arr);

			//result
			if (isSorted(arr)) {
				printArray(arr);
				System.out.println("Sorted Well");
			} else {
				System.out.println("Something Wrong");
			}
		}
	}

}
```
