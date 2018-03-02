package com.jason.algorithm.stack;

import java.util.Stack;

/**
 * 不借助其他数据结构, 仅通过递归方式实现栈的逆排序
 * 如 stack (底->顶)1,2,3,4,5 -> (底->顶)5,4,3,2,1
 *
 * @author jason-geng
 * @date 3/3/18
 */
public class ReverseStack {

	public static void reverse(Stack<Integer> stack){
		if (stack.isEmpty()){
			return;
		}

		Integer last = getAndRemoveLast(stack);
		reverse(stack);
		stack.push(last);
	}
	
	private static Integer getAndRemoveLast(Stack<Integer> stack) {
		Integer result = stack.pop();

		if (stack.isEmpty()){
			return result;
		}

		Integer last = getAndRemoveLast(stack);
		stack.push(result);
		return last;
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		reverse(stack);
		
		for (int i = 0; i < 5; i++) {
			System.out.println(stack.pop());
		}
	}
}
