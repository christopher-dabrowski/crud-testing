package entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "shopping_list")
public class ShoppingList {
	private int product_id;

	private int amount;

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public ShoppingList() {
	}

	public ShoppingList(int product_id, int amount) {
		this.product_id = product_id;
		this.amount = amount;
	}
}
