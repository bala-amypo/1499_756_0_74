@RestController
public class LocationController{
    @autowired
    LocationService locationservice;
    @PostMapping("/addstudent")
    public LocationEntity add(@RequestBody LocationEntity le){
        return locationservice.createlocation(le);
    }
    @
}