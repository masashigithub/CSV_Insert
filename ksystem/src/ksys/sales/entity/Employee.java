package ksys.sales.entity;

public class Employee {

	/**
	 * 従業員名
	 */
	private String name;

	/**
	 * 年齢
	 */
	private int age;

	/**
	 * 住所
	 */
	private String adress;

	/**
	 * コンストラクタ 引数なし
	 */
	public Employee() {

	}

	/**
	 * コンストラクタ
	 *
	 * @param name
	 * @param age
	 * @param adress
	 */
	public Employee(String name, int age, String adress) {
		this.name = name;
		this.age = age;
		this.adress = adress;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            セットする age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return adress
	 */
	public String getAdress() {
		return adress;
	}

	/**
	 * @param adress
	 *            セットする adress
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}

}
