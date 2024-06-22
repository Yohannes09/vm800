package com.techelevator;

import com.techelevator.vendomatic800.Vendomatic800;

public class Application {

	public static void main(String[] args) {
		Vendomatic800 vendomatic800 = new Vendomatic800();
		vendomatic800.vm800Screen();
		vendomatic800.readInventory();
		vendomatic800.ru();
	}
}
