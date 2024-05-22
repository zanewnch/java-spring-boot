from typing import Optional
from datetime import date, time

from django.db import models

'''
這個邏輯是這樣,django system default 會set id column to be primary key, 然後重點是這個id不需要寫在model裡面
so in this case, 我讓system use default id setting, 然後把invoice_id 當成一個普通的column.
id 的 data type 會是 int
'''


class SupermarketSale(models.Model):
    # 如果不寫invoice_id, 就會用default auto increment, 但現在是要套用csv value to table
    invoice_id: Optional[str] = models.CharField(max_length=100, unique=True, null=True)
    branch: str = models.CharField(max_length=1)
    city: str = models.CharField(max_length=100)
    customer_type: str = models.CharField(max_length=100)
    gender: str = models.CharField(max_length=10)
    product_line: str = models.CharField(max_length=100)
    unit_price: float = models.DecimalField(max_digits=10, decimal_places=2)
    quantity: int = models.IntegerField()
    tax_5_percent: float = models.DecimalField(max_digits=10, decimal_places=2)
    total: float = models.DecimalField(max_digits=10, decimal_places=2)
    date: date = models.DateField()
    time: time = models.TimeField()
    payment: str = models.CharField(max_length=100)
    cogs: float = models.DecimalField(max_digits=10, decimal_places=2)
    gross_margin_percentage: float = models.DecimalField(max_digits=10, decimal_places=6)
    gross_income: float = models.DecimalField(max_digits=10, decimal_places=2)
    rating: float = models.DecimalField(max_digits=10, decimal_places=1)

    def __str__(self):
        return self.invoice_id

    class Meta:
        # Django handles the creation, modification, and deletion of the database table. This includes generating SQL commands for migrations.
        managed = True
        # specify the database table name, do not use the system default
        db_table = 'supermarket'
        # specify this model is belonged to which application.
        app_label = 'supermarket'
