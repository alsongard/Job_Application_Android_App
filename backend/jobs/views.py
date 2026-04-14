from django.shortcuts import render
from .serializers import JobSerializer
from .models import Job
from django.http import JsonResponse, HttpResponse
from rest_framework.renderers import JSONRenderer
from rest_framework.decorators import api_view 
from rest_framework.response import Response
from rest_framework import status
# Create your views here.

@api_view()
def get_jobs_view(request):
    """
    provides a list of all jobs
    """
    if request.method == "GET":
        jobs = Job.objects.all() # gets all jobs
        serializer = JobSerializer(jobs, many=True) # use many=True when geting a list of objects
        # we have data in python native instance
        
        return Response(serializer.data, status=status.HTTP_200_OK) # when using Response frm  rest-framework this is automatically converted into a JSON object

        



def job_index(request):
    return HttpResponse("<h1>Job Index Page</h1>")