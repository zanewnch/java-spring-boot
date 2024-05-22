from django.test import TestCase

import os

# Replace this with the path to your CSV file
csv_file_path = '../static/supermarket_sales.csv'

# Check if the file exists at the specified path
if os.path.exists(csv_file_path):
    print(f"File found at: {csv_file_path}")
else:
    print(f"File not found at: {csv_file_path}")

