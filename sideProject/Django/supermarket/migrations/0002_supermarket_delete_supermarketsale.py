# Generated by Django 4.2.7 on 2023-11-15 11:17

from django.db import migrations, models


class Migration(migrations.Migration):
    dependencies = [
        ("supermarket", "0001_initial"),
    ]

    operations = [
        migrations.CreateModel(
            name="Supermarket",
            fields=[
                (
                    "id",
                    models.BigAutoField(
                        auto_created=True,
                        primary_key=True,
                        serialize=False,
                        verbose_name="ID",
                    ),
                ),
                ("branch", models.CharField(max_length=1)),
                ("city", models.CharField(max_length=100)),
                ("customer_type", models.CharField(max_length=100)),
                ("gender", models.CharField(max_length=10)),
                ("product_line", models.CharField(max_length=100)),
                ("unit_price", models.DecimalField(decimal_places=2, max_digits=10)),
                ("quantity", models.IntegerField()),
                ("tax_5_percent", models.DecimalField(decimal_places=2, max_digits=10)),
                ("total", models.DecimalField(decimal_places=2, max_digits=10)),
                ("date", models.DateField()),
                ("time", models.TimeField()),
                ("payment", models.CharField(max_length=100)),
                ("cogs", models.DecimalField(decimal_places=2, max_digits=10)),
                (
                    "gross_margin_percentage",
                    models.DecimalField(decimal_places=6, max_digits=10),
                ),
                ("gross_income", models.DecimalField(decimal_places=2, max_digits=10)),
                ("rating", models.DecimalField(decimal_places=1, max_digits=10)),
            ],
            options={
                "db_table": "supermarket",
                "managed": True,
            },
        ),
        migrations.DeleteModel(
            name="SupermarketSale",
        ),
    ]
