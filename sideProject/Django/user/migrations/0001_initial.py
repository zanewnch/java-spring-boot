# Generated by Django 4.2.7 on 2023-12-22 15:28

from django.db import migrations, models
import django.utils.timezone


class Migration(migrations.Migration):
    initial = True

    dependencies = []

    operations = [
        migrations.CreateModel(
            name="User",
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
                ("username", models.CharField(max_length=150, unique=True)),
                ("password", models.CharField(max_length=128)),
                (
                    "registration_date",
                    models.DateTimeField(default=django.utils.timezone.now),
                ),
                ("last_login_date", models.DateTimeField(blank=True, null=True)),
                ("user_status", models.CharField(max_length=50)),
            ],
            options={
                "db_table": "user",
                "managed": True,
            },
        ),
    ]