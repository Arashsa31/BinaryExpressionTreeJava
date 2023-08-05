package LabProgram1213;

/**
*
* Student tasks: implement tasks as specified in this file
*
* Note: BXT Represents a binary expression tree.
* BXT can build itself from a postorder expression.  
* It can evaluate and print itself. It also prints an inorder string and a preorder string.  
*/

import java.util.*;

class BXT {
	private TreeNode root;

	public BXT() {
		root = null;
	}

	public TreeNode getRoot() {
		return root;
	}

	public void buildTree(String postfix) {
		// *** Student task ***
		/*
		 * The argument string is in postfix notation. Build the tree as specified in
		 * the document Enter your code below ***
		 */
		Stack<TreeNode> operandStack = new Stack<TreeNode>();

		// parse the post-fix expression string one token at a time, until there is no
		// more token to be parsed
		// if the token is an operand, push the token into stack
		// if the token is an operator, pop a right operand, pop a left operand, and
		// perform operation based on the operator

		// pop an operand to be right child, pop another operand to be the left child
		// use the operator to be the root

		StringTokenizer tokens = new StringTokenizer(postfix);

		while (tokens.hasMoreElements()) {
			String token = tokens.nextToken();
			if (isOperator(token)) {
				// perform build tree operation
				TreeNode t = new TreeNode(token); // the new subtree has operator in root
				t.setRight(operandStack.pop()); // pop an operand to be right child
				t.setLeft(operandStack.pop()); // pop another operand to be left child
				operandStack.push(t);
			} else {
				// push operand to stack
				operandStack.push(new TreeNode(token)); // this subtree will be used as right operand of parent operator
			}
		}

	}

	private boolean isOperator(String token) {
		switch (token) {
		case "+":
		case "-":
		case "*":
		case "/":
		case "%":
			return true;
		default:
			return false;
		}
	}

	public double evaluateTree() {
		// *** Student task ***
		/*
		 * Do this recursively. If the node is an operator, recursively evaluate the
		 * left child and the right child, and return the result. Else the node is a
		 * number, so it can be converted into a double, and returned. Enter your code
		 * below ***
		 */

		// start from root
		// recursively evaluate left subtree for first operand result
		// recursively evaluate right subtree for second operand result
		// perform operation based on the left first operand and the second operand

		return eval(root); // replace it with yours
	}

	private double eval(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (isOperator(root.getData())) {
			// switch the root as a character for operation cases
			// evaluation of left operate with right subtree
			switch (root.getData().charAt(0)) {
			case '+':
				return eval(root.getLeft()) + eval(root.getRight());
			case '-':
				return eval(root.getLeft()) - eval(root.getRight());
			case '*':
				return eval(root.getLeft()) * eval(root.getRight());
			case '/':
				return eval(root.getLeft()) / eval(root.getRight());
			case '%':
				return eval(root.getLeft()) % eval(root.getRight());
			}
		}

		return 0;
	}

	public String display() {// optional, it is not for grading
		// *** Student task ***
		/*
		 * Display tree structure. Plese refer to GA2 if you need to refresh your
		 * knowledge Enter your code below ***
		 */
		return null; // replace it with yours
	}

	public String infix() {
		// *** Student task ***
		/*
		 * Infix is characterized by the placement of operators between operands; Enter
		 * your code below ***
		 */

		return infix(root);
	}

	private String infix(TreeNode node) {
		if (node == null) {
			return "";
		}
		if (isOperator(node.getData())) {
			return infix(node.getLeft()) + " " + node.getData() + " " + infix(node.getRight());
		} else {
			return node.getData();
		}
	}

	public String prefix() {
		// *** Student task ***
		/*
		 * Prefix expression notation requires that all operators precede the two
		 * operands that they work on; Enter your code below ***
		 */

		return prefix(root);
	}

	private String prefix(TreeNode node) {
		if (node == null) {
			return "";
		}
		if (isOperator(node.getData())) {
			return node.getData() + " " + prefix(node.getLeft()) + " " + prefix(node.getRight());
		} else {
			return node.getData();
		}
	}

	public String postfix() {
		// *** Student task ***
		/*
		 * Postfix requires that its operators come after the corresponding operands
		 *** Enter your code below ***
		 */

		return postfix(root);
	}

	private String postfix(TreeNode node) {
		if (node == null) {
			return "";
		}
		if (isOperator(node.getData())) {
			return postfix(node.getLeft()) + " " + postfix(node.getRight()) + " " + node.getData();
		} else {
			return node.getData();
		}
	}

}