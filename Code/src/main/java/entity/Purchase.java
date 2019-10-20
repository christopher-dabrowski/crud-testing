package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Currency;

@Entity
@Table(name = "Purchase")
public class Purchase {
	@Id
	private int id;

	private int product_id;

	private Currency money;

	private LocalDateTime date;

	private int family_member;

	private int amount;

	private boolean settled;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public Currency getMoney() {
		return money;
	}

	public void setMoney(Currency money) {
		this.money = money;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public int getFamily_member() {
		return family_member;
	}

	public void setFamily_member(int family_member) {
		this.family_member = family_member;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isSettled() {
		return settled;
	}

	public void setSettled(boolean settled) {
		this.settled = settled;
	}
}