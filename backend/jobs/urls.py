from django.urls import path

from .views import get_jobs_view, job_index


urlpatterns = [
    path("", job_index, name="job"),
    path("alljobs/", get_jobs_view, name="get_all_jobs")
]