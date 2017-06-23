public class AVL {
	private TreeNode root;
	private boolean h;
	private int length;

	public AVL() {
		this.root = null;
		this.h = true;
		this.length = 0;
	}

	private boolean leftCondition(Item a, Item b) {
		return a.getCity().compareTo(b.getCity()) < 0 || a.getCity().equals(b.getCity()) && a.getName().compareTo(b.getName()) < 0;
	}

	public AVL insert(Item elem) {
		this.root = this.insert(elem, this.root);
		this.length++;
		return this;
	}

	private TreeNode insert(Item elem, TreeNode node) {
		if (node == null) {
			TreeNode newNode = new TreeNode(elem);
			this.h = true;
			return newNode;
		} else if (leftCondition(elem, node.getInfo())) {
			node.setLeft(this.insert(elem, node.getLeft()));
			node = this.balanceRight(node);
			return node;
		} else {
			node.setRight(this.insert(elem, node.getRight()));
			node = this.balanceLeft(node);
			return node;
		}
	}

	private TreeNode balanceRight(TreeNode node) {
		if (this.h) {
			byte factor = node.getBalanceFactor();
			if (factor == 1) {
				node.setBalanceFactor((byte) 0);
				this.h = false;
			} else if (factor == 0) node.setBalanceFactor((byte) -1);
			else if (factor == -1) node = this.rotateRight(node);
		}
		return node;
	}

	private TreeNode balanceLeft(TreeNode node) {
		if (this.h) {
			byte factor = node.getBalanceFactor();
			if (factor == 1) node = this.rotateLeft(node);
			else if (factor == 0) node.setBalanceFactor((byte) 1);
			else if (factor == 1) {
				node.setBalanceFactor((byte) 0);
				this.h = false;
			}
		}
		return node;
	}

	private TreeNode rotateRight(TreeNode node) {
		TreeNode temp1, temp2;
		temp1 = node.getLeft();
		if (temp1.getBalanceFactor() == -1) {
			node.setLeft(temp1.getRight());
			temp1.setRight(node);
			node.setBalanceFactor((byte) 0);
			node = temp1;
		} else {
			temp2 = temp1.getRight();
			temp1.setRight(temp2.getLeft());
			temp2.setLeft(temp1);
			node.setLeft(temp2.getRight());
			temp2.setRight(node);
			if (temp2.getBalanceFactor() == -1) node.setBalanceFactor((byte) 1);
			else node.setBalanceFactor((byte) 0);

			if (temp2.getBalanceFactor() == 1) temp1.setBalanceFactor((byte) -1);
			else temp1.setBalanceFactor((byte) 0);
			node = temp2;
		}
		node.setBalanceFactor((byte) 0);
		this.h = false;
		return node;
	}

	private TreeNode rotateLeft(TreeNode node) {
		TreeNode temp1, temp2;
		temp1 = node.getRight();
		if (temp1.getBalanceFactor() == 1) {
			node.setRight(temp1.getLeft());
			temp1.setLeft(node);
			node.setBalanceFactor((byte) 0);
			node = temp1;
		} else {
			temp2 = temp1.getLeft();
			temp1.setLeft(temp2.getRight());
			temp2.setRight(temp1);
			node.setRight(temp2.getLeft());
			temp2.setLeft(node);
			if (temp2.getBalanceFactor() == 1) node.setBalanceFactor((byte) -1);
			else node.setBalanceFactor((byte) 0);
			if (temp2.getBalanceFactor() == -1) temp1.setBalanceFactor((byte) 1);
			else temp1.setBalanceFactor((byte) 0);
			node = temp2;
		}
		node.setBalanceFactor((byte) 0);
		this.h = false;
		return node;
	}

	public String[] search(String[] cities) {
		String[] lines = new String[cities.length];
		for (int i = 0; i < cities.length; i++) {
			lines[i] = this.search(cities[i], this.root);
			if (lines[i].isEmpty()) lines[i] = "MUNICÍPIO INEXISTENTE";
		}
		return lines;

	}

	private String search(String city, TreeNode node) {
		String str = "";
		if (node != null) {
			if (city.compareTo(node.getInfo().getCity()) < 0) str = this.search(city, node.getLeft());
			else if (city.compareTo(node.getInfo().getCity()) > 0) str = this.search(city, node.getRight());
			else {
				str += node.getInfo().getName();
				String left = search(city, node.getLeft());
				if (!left.isEmpty()) str += "\r\n" + left;
				String right = search(city, node.getRight());
				if (!right.isEmpty()) str += "\r\n" + right;
			}
		}
		return str;
	}
}
