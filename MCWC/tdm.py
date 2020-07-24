import time

data_sent = 0
time_slice = 10
station_time_list = [10,20,10,10,20,20,30,30,10,10,20,50]
total = sum(station_time_list)

print(total)

while data_sent < total:
    for i, station_time in enumerate(station_time_list):
        if station_time>0:
            print(f"Channel {i+1} is Sending Data")
            if station_time>time_slice:
                data_sent += time_slice
                station_time -= time_slice
            else:
                data_sent += station_time
                station_time = 0
            time.sleep(0.1)

print(data_sent)