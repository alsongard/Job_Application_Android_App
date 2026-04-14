from django.db import models

# Create your models here.
class UserModel(models.Model):
    user_email = models.CharField(max_length=80)
    password = models.CharField(max_length=110)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    def __str__(self):
        return f"Email: {self.user_email}\nPassword: {self.password}\nCreated: {self.created_at}\nUpdated_at: {self.updated_at} "