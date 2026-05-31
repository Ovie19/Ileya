def display_store_header(cashier_name, customer_name):
    print(f"""SEMICOLON STORES
MAIN BRANCH
LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.
TEL: 03293828343
Date: 18-Dec-22 8:48:11 pm
Cashier: {cashier_name}
Customer Name: {customer_name}""")

    print("=" * 56)
    print(f"{'ITEM':<15}{'QTY':>5}{'PRICE':>18}{'TOTAL(NGN)':>15}")
    print("-" * 56)


def show_all_items_quantity_and_price(item_list, quantity_list, price_list):
    sub_total = 0

    for index in range(len(item_list)):
        item = item_list[index]
        quantity = quantity_list[index]
        price = price_list[index]

        total = quantity * price
        sub_total += total

        print(f"{item:<15}{quantity:>5}{price:>18.2f}{total:>15.2f}")

    return sub_total


def display_subtotal_discount_and_vat(sub_total, discount):
    print("\n" + "-" * 56)

    discount_on_price = sub_total * discount / 100
    vat_on_price = sub_total * 0.175

    print(f"{'Sub Total':>38}: {sub_total:>15.2f}")
    print(f"{'Discount':>38}: {discount_on_price:>15.2f}")
    print(f"{'VAT @ 17.50%':>38}: {vat_on_price:>15.2f}")

    print("=" * 56)

    return sub_total - discount_on_price + vat_on_price



item_list = []
quantity_list = []
price_list = []

customer_name = input("What is the customer's Name?\n")

while True:
    item_name = input("\nWhat did the user buy?\n")
    item_list.append(item_name)

    quantity = int(input("How many pieces?\n"))
    quantity_list.append(quantity)

    price = float(input("How much per unit?\n"))
    price_list.append(price)

    option = input("Add more Items? ")
    if option.strip().lower() == "no":
        break

cashier_name = input("\nWhat is your name?\n")
discount = int(input("How much discount will he get?\n"))

print()

display_store_header(cashier_name, customer_name)

sub_total = show_all_items_quantity_and_price(
    item_list, quantity_list, price_list
)

total_bill_price = display_subtotal_discount_and_vat(
    sub_total, discount
)

print(f"{'Bill Total':>38}: {total_bill_price:>15.2f}")
print("=" * 56)
print(f"THIS IS NOT A RECEIPT KINDLY PAY {total_bill_price:.2f}")
print("=" * 56)

print("\n\n")

amount_paid = float(input("How much did the customer give to you?\n"))

display_store_header(cashier_name, customer_name)

show_all_items_quantity_and_price(
    item_list, quantity_list, price_list
)

display_subtotal_discount_and_vat(sub_total, discount)

print(f"{'Bill Total':>38}: {total_bill_price:>15.2f}")
print(f"{'Amount Paid':>38}: {amount_paid:>15.2f}")
print(f"{'Balance':>38}: {(amount_paid - total_bill_price):>15.2f}")

print("=" * 56)
print("\t\tTHANK YOU FOR YOUR PATRONAGE")
print("=" * 56)
