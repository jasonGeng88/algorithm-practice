package com.jason.algorithm.stack;

import java.util.Stack;

/**
 * 仅借助一个额外的stack,完成对stack从顶到底的从大到小排序
 * 例子: stack (顶->底) 2,3,1,4,5 -> 5,4,3,2,1
 *
 * @author jason-geng
 * @date 3/3/18
 */
public class SortStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(5);
		stack.push(4);
		stack.push(1);
		stack.push(3);
		stack.push(2);

		sort(stack);

		for (int i = 0; i < 5; i++) {
			System.out.println(stack.pop());
		}
	}

	private static void sort(Stack<Integer> stack) {
		Stack<Integer> help = new Stack<Integer>();

		while (!stack.isEmpty()) {
			Integer curr = stack.pop();

			while (!help.isEmpty() && curr > help.peek()) {
				stack.push(help.pop());
			}
			help.push(curr);
		}

		while (!help.isEmpty()) {
			stack.push(help.pop());
		}
	}
}
