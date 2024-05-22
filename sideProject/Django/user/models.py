from django.utils import timezone
from django.db import models

'''
The completed step:
1. finish the models.py
2. Add the views.py part(in this case I only create the database without other api function)
3. open setting.py the add this app(user) to the installed_app attribute
4. python manage.py makemigrations
5. python manage.py migrate
6. python manage.py runserver

After running the sever, the db also be created.
'''


class User(models.Model):
    username = models.CharField(max_length=150, unique=True)
    password = models.CharField(
        max_length=128)  # Note: For real applications, use Django's built-in User model for better security
    registration_date = models.DateTimeField(default=timezone.now)
    last_login_date = models.DateTimeField(null=True, blank=True)
    user_status = models.CharField(max_length=50)

    def __str__(self):
        return self.username

    class Meta:
        # Django handles the creation, modification, and deletion of the database table. This includes generating SQL commands for migrations.
        managed = True
        # specify the database table name, do not use the system default
        db_table = 'user'
        # specify this model is belonged to which application.
        app_label = 'user'
