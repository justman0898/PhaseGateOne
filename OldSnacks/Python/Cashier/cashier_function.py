from datetime import datetime
VAT = 0.175
all_items = []

def get_discount(discount):
	new_discount = discount/100
	total = get_sub_total()
	return total * new_discount

def add_item(item, quantity, amount):
	if quantity < 0 or amount < 0:
		raise ValueError("Bad input")
	items = []
	total = quantity * amount
	items.append(item)
	items.append(quantity)
	items.append(amount)
	items.append(total)
	all_items.append(items)
def get_all_items():
	return all_items
def get_sub_total():
	sum = 0
	for items in range (len(all_items)):
		for item in range (0, 1):
			sum = sum + all_items[items][3]
	return sum
def get_vat_amount():
	return VAT * get_sub_total()
def get_bill_total(discount):
	return (get_sub_total()  + get_vat_amount()) - get_discount(discount)

def print_invoice(customer_name, discount):
	now = datetime.now()
	date_str = now.strftime("%Y-%m-%d %H:%M:%S")
	message = f"""
SEMICOLON STORES
MAIN BRANCH
LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.
TEL: 09068325098
Date: {date_str}
Cashier: Cashier's name
Customer's Name: {customer_name}
==========================================================================
		Item(s)      QTY            PRICE           TOTAL(N)
--------------------------------------------------------------------------
{format_items()}


--------------------------------------------------------------------------
				Sub-Total:	{get_sub_total():.2f}
				Discount: 	{get_discount(discount):.2f}
				VAT @17.50:	{get_vat_amount():.2f}
==========================================================================
				BILL TOTAL:	{get_bill_total(discount)}
==========================================================================
THIS IS NOT A RECIEPT KINDLY PAY {get_bill_total(discount)}
==========================================================================

	"""
	return message

def format_items():
	cart = get_all_items()
	output = ""
	for row in cart:
		for item in row:
        		output += f"\t{item}\t"
		output += "\n"
	return output
def get_balance(amount_paid, discount):
	if (amount_paid < get_bill_total(discount)):
		raise ValueError("Amount must be greater than balance")	   
	return amount_paid - get_bill_total(discount)	

def print_final_invoice(customer_name, discount, amount_paid):
	now = datetime.now()
	date_str = now.strftime("%Y-%m-%d %H:%M:%S")

	message = f"""
SEMICOLON STORES
MAIN BRANCH
LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.
TEL: 09068325098
Date: {date_str}
Cashier: Cashier's name
Customer's Name: {customer_name}
==========================================================================
    Item(s)      QTY            PRICE           TOTAL(N)
--------------------------------------------------------------------------
{format_items()}


--------------------------------------------------------------------------
				Sub-Total:	{get_sub_total():.2f}
				Discount: 	{get_discount(discount):.2f}
				VAT @17.50:	{get_vat_amount():.2f}
==========================================================================
				BILL TOTAL:	{get_bill_total(discount):.2f}
				Amount paid:	{amount_paid:.2f}
				Balance:	{get_balance(amount_paid,discount):.2f}
==========================================================================
			THANKS FOR YOUR PATRONAGE
==========================================================================

"""
	return message


def get_valid_input(prompt, input_type=float):
	while True:
		try:
			value = input_type(input(prompt))
			return value
		except ValueError:
			print(f"Invalid input. Please enter a valid {input_type.__name__}.")








		