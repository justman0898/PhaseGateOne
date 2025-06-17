import cashier_function

def main():
	customer_name = input("Enter Customer's Name: ")
	while True:
		try:
			item = input("What did the customer buy? ")
			quantity = cashier_function.get_valid_input("How many pieces? ", int)
			price = cashier_function.get_valid_input("How much per unit? ", float)
			cashier_function.add_item(item, quantity, price)
		
			while True:
				user_input = input("Add more item? (yes/no): ").strip().lower()
				if user_input == "yes":
					item = input("What did the customer buy? ")
					quantity = cashier_function.get_valid_input("How many pieces? ", int)
					price = cashier_function.get_valid_input("How much per unit? ", float)
					cashier_function.add_item(item, quantity, price)
				elif user_input == "no":
					discount = cashier_function.get_valid_input("How much discount will they get? ", float)
					cashier_function.get_discount(discount)
					print(cashier_function.print_invoice(customer_name, discount))
					amount_paid = cashier_function.get_valid_input("Enter amount paid: ", float)
					print(cashier_function.print_final_invoice(customer_name, discount, amount_paid))
					return
				else:
					print("Please answer 'yes' or 'no'.")
		except Exception as e:
			print("An error occurred. Please try again.")
			print("Details:", e)

print(main())