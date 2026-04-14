```bash
python3 manage.py startapp user # used to start an app in django: an app is a package

django-admin startproject projectName # create project
```

setup a view; 
in app/views/views.py
```py
def index(request):
    HttpResponse("Some Text")
    
```

**configuring urls in your app**  
```py
from .views import index
urlpatters = [
    path("/about", index, name="about")
]
```

**Add urls to project urls file:**
```py
from django.contrib import admin
from django.urls import path, include

urlpatterns = [
    path('admin/', admin.site.urls),
    path("users/", include("user.urls"))
]

```

To register your model we do:
- Register Model in app/admin.py file:
```py
from django.contrib import admin
from .models import UserModel
# Register your models here.
admin.site.register(UserModel)
```

**Class Meta**   
The class Meta inside a Django model is used to supply metadata (configuration) for that model. The ordering attribute is one of those meta options.
What does ordering = ["created"] do?

It tells Django to order all queries for that model by the created field by default (ascending order). If you want descending order, you use a hyphen: ordering = ["-created"].



**Serializer**  
we use serializer to serialize a record. 
E.g
```py
serializer = SnippetSerializer(snippet)
serializer.data
{'id': 2, 'title': '', 'code': 'print("hello, world")\n', 'linenos': False, 'language': 'python', 'style': 'friendly'}
```
The above translated the model instance into Python Native data tyyes.

To finalize the serialization process we render it into JSON
```py
content = JSONRenderer().render(serializer.data)
```


JsonResponse is a Django class that returns an HTTP response with JSON content. It automatically serializes a Python dictionary to JSON. The 'safe' parameter controls whether non-dict objects are allowed. Typically, you can pass a dictionary or list directly.

JsonResponse is preferred when writting function based views while Render() from Django-Rest-framework can take a Python dictionary or a list of Python Dictionaries: Use DRF’s Response(serializer.data) (which uses JSONRenderer automatically and is the recommended approach for DRF views)


There are two ways to deploy your Django project on Render, either by declaring your services within your repository using a render.yaml file or by manually setting up your services using the dashboard. In this tutorial, we will walk through both options.


The render.yaml file defines infrastructure for your Django project on Render. Below is a breakdown of its variables, their relationships, and purposes — specifically for a Django app using PostgreSQL

```yaml
databases:
  - name: jobappdb  # render launches an instance of postgresql and with it creates a database jobappdb: this name is for infrastructure management
    plan: free # Render’s free PostgreSQL tier
    databaseName: jobappdb # actual name for the DATABASE: CREATE DATABASE jobappdb
    user: myuser  # user created with access to this DB: jobappdb

services:
  - type: web # deploys a public web services: handles http request
    plan: free # Render’s free instance
    name: jobapp # Service name shown in dashboard; part of the default URL 
    runtime: python # Uses Python runtime;
    buildCommand: './build.sh' # Runs during deployment. Typically installs deps and runs migrations:
    startCommand: 'python -m gunicorn thebackend.wsgi:application'   # Starts Gunicorn WSGI server to serve Django app.
envVars:
  - key: DATABASE_URL # Django uses this to connect to PostgreSQL.
    fromDatabase: #fromDatabase dynamically injects the full connection string (host, port, user, password, SSL mode).
      name: jobappdb
      property: connectionString   
```
Yes, runtime: python sets the language environment for the web service.

Render uses it to:

    Install the appropriate Python version (from runtime.txt or default)

    Run build commands like pip install -r requirements.txt

    Prepare the execution environment for Python-based apps (e.g., Django, Flask) 