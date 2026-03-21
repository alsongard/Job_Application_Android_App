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