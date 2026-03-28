from django.shortcuts import render
from django.http import HttpResponse
from rest_framework.decorators import api_view
from rest_framework.parsers import JSONParser
from .serializer import UserSerializer
from django.http import HttpResponse, JsonResponse
# Create your views here.
def index(request):
    return HttpResponse("Hello This is user App")

@api_view(["POST"])
def register_user(request):
    print("request")
    print(request)
    data  = JSONParser().parse(request)
    print('data')
    print(data)
    serializer = UserSerializer(data)
    if serializer.is_valid():
        serializer.save()
        return JsonResponse(serializer.data)
    return JsonResponse(serializer.errors, status=400)
