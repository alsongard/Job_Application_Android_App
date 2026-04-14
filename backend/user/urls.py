from django.urls import path

from .views import index, register_user

urlpatterns = [
    path("", index, name="index"),
    path("register/", register_user )
]