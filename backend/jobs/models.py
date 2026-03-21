from django.db import models
from django.contrib.postgres.fields import ArrayField

# Create your models here.
class Job(models.Model):
    job_category = models.CharField(max_length=255)
    JOB_TYPE_CHOICES=[
        ("full-time", "Full Time"),
        ("part-time", "Part Time"),
        ("hybrid", "Hybrid")
    ]
    job_type = models.CharField(max_length=255, choices=JOB_TYPE_CHOICES)
    EXPERIENCE_LEVEL_CHOICES = [
        ("junior" , "Junior"),
        ("internship", "Internship"),
        ("senior"  , "Senior"),
        ("attachment", "Attachment")
    ]
    experience_level = models.CharField(max_length=255, choices=EXPERIENCE_LEVEL_CHOICES)
    job_description =  models.CharField(max_length=1000)
    job_requirements = ArrayField(models.CharField(max_length=100), size=15)
    location = models.CharField(max_length=255)
    application_deadline = models.DateField(editable=True)
    company_name = models.CharField(max_length=500)
    website = models.CharField(max_length=500)
    mission = models.CharField(max_length=1500)
    logo= models.CharField(max_length=500)





"""
    <string name="job_category_1">Software Engineering</string>
    <string name="type_1">Full-time</string>
    <string name="experience_level_1">Senior Level</string>
    <string name="job_description_1">You will lead the architectural design and implementation of scalable cloud services, ensuring high performance and reliability for millions of global users.</string>
    <string-array name="job_requirements_1">
        <item>BS degree in Computer Science or equivalent practical experience</item>
        <item>Experience with Java</item>
        <item>C++</item>
        <item>or Go</item>
        <item>Expertise in distributed systems and microservices architecture</item>
        <item>Proven track record of technical leadership and mentoring junior engineers</item>
    </string-array>
    <string name="location_1">Mountain View, CA (Hybrid)</string>
    <string name="application_deadline_1">2026-03-15</string>
    <string name="company_name_1">Google</string>
    <string name="website_1">https://about.google</string>
    <string name="mission_1">To organize the world\'s information and make it universally accessible and useful.</string>
    <string name="logo_1">https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png</string>
"""