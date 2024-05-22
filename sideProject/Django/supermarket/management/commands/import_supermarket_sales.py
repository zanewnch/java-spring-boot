import csv
from datetime import datetime
from typing import Any, Dict
from django.core.management.base import BaseCommand, CommandParser
from supermarket.models import SupermarketSale


# python manage.py import_supermarket_sales ./static/supermarket_sales.csv

class Command(BaseCommand):
    help: str = 'Load a supermarket sales csv file into the database'

    def add_arguments(self, parser: CommandParser) -> None:
        parser.add_argument('csv_file', type=str)

    def handle(self, *args, **kwargs) -> None:
        csv_file_path = kwargs['csv_file']
        with open(csv_file_path, mode='r', encoding='utf-8') as file:
            reader = csv.DictReader(file)
            for row in reader:
                sale, created = SupermarketSale.objects.get_or_create(
                    invoice_id=row['Invoice ID'],
                    defaults={
                        'branch': row['Branch'],
                        'city': row['City'],
                        'customer_type': row['Customer type'],
                        'gender': row['Gender'],
                        'product_line': row['Product line'],
                        'unit_price': row['Unit price'],
                        'quantity': row['Quantity'],
                        'tax_5_percent': row['Tax 5%'],
                        'total': row['Total'],
                        'date': datetime.strptime(row['Date'], '%m/%d/%Y').date(),
                        'time': datetime.strptime(row['Time'], '%H:%M').time(),
                        'payment': row['Payment'],
                        'cogs': row['cogs'],
                        'gross_margin_percentage': row['gross margin percentage'],
                        'gross_income': row['gross income'],
                        'rating': row['Rating']
                    }
                )
                if created:
                    self.stdout.write(self.style.SUCCESS(f'Successfully added sale {sale.invoice_id}'))
                else:
                    self.stdout.write(self.style.WARNING(f'Sale {sale.invoice_id} already exists'))
