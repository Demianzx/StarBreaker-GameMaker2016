cur_width = max(1, window_get_width());
cur_height = max(1, window_get_height());
var ratio = cur_width / cur_height;
if cur_width < cur_height
    {
    view_wview[0] = min_height * ratio;
    view_hview[0] = min_height;
    }
else
    {
    view_wview[0] = min_width;
    view_hview[0] = min_width / ratio;
    }
view_wport[0] = cur_width;
view_hport[0] = cur_height;
surface_resize(application_surface, view_wview[0], view_hview[0]);
