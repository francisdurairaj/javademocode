
Run both the apps StudentServiceHystrix and SchoolServiceHystrix

URLS :

Invoke --> http://localhost:8098/getstudentdetailsforschool/BCA ---->StudentServiceHystrix

Invoke --> http://localhost:9098/getschooldetails/BCA  ---->SchoolServiceHystrix

Now stop the StudentServiceHystrix
and again invoke --> http://localhost:9098/getschooldetails/BCA