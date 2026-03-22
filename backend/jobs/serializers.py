# using model serializers
from .models import Job
from rest_framework import serializers

class JobSerializer(serializers.ModelSerializer):
    class Meta:
        model = Job
        fields = "__all__" # this includes all fields