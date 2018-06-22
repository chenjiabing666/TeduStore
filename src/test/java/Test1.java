import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.junit.Test;

import com.sun.javafx.image.impl.IntArgb;

public class Test1 {
	/**
	 * 思想： 从第一个开始取值和后面的元素开始比较，如果有比它小的，那么就交换元素值
	 * 外层循环从第一个元素开始，内层循环保证了从外层循环的后面一个元素开始，这样就是保证了比较
	 * 
	 * @param arrary
	 *            待排序的数组
	 */
	public static void selectSort(int[] arrary) {
		// 外层循环，从第一个元素开始直到倒数第二个元素
		for (int i = 0; i < arrary.length - 1; i++) {
			int k = i; // 这个是保存最小元素的下标，初始化是i
			// 内层循环，从i+1个元素开始直到最后一个元素
			for (int j = i + 1; j < arrary.length; j++) {
				// 如果下标为j的元素比下标为k的元素小，那么k=j
				if (arrary[j] < arrary[k]) {
					k = j; // 记录此时的最小的下标
				}
			}
			// 如果此时的k改变了，即是不等于初始值i了，那么表示找到比初始值更小的了，则交换位置
			if (k != i) {
				// arrary[k]和arrary[i]交换位置，因为最小的放在前面
				int temp = arrary[i];
				arrary[i] = arrary[k];
				arrary[k] = temp;
			}
		}
	}

	public static void bubbleSort(int[] arrary) {
		for (int i = 0; i < arrary.length - 1; i++) {

			for (int j = 0; j < arrary.length - 1 - i; j++) {
				if (arrary[j] > arrary[j + 1]) {
					int t = arrary[j];
					arrary[j] = arrary[j + 1];
					arrary[j + 1] = t;
				}
			}

		}
	}

	@Test
	public void test() {
		char grade='c';
		switch (grade) {
		case 'a':
			System.out.println("a");
//			break;
		case 'c':
			System.out.println("c");
//			break;
		case 'b':
			System.out.println("b");
//			break;
		default:
			System.out.println("default");
			break;
		}
	}

}
