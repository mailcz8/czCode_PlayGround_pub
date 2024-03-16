# import youtube_dl
from pytube import YouTube
import os, sys

class YouTube_DL():
    def __init__(self):
        self.youtube_url = ""

    def check_yt_url(self):
        try:
            if len(sys.argv) <= 1:
                self.youtube_url = input("Enter the URL of the video you want to download: \n>> ")
            else:
                self.youtube_url = sys.argv[1]
        except Exception as err:
            print(err)
            print("No url was entered at command line...")
            # self.youtube_url = "https://www.youtube.com/watch?v=2r7pq4XbUL4" #70、80、90年代经典老歌
            # self.youtube_url = "https://www.youtube.com/watch?v=AMskvxEWf0k" #Big Fish (大魚)
        print("YT dl url set to: ", self.youtube_url)

    def pytube_mp3_only(self):
        # url input from user
        try:
            if len(sys.argv) <= 1:
                # yt = str(input("Enter the URL of the video you want to download: \n>> "))
                # yt = YouTube(str(input("Enter the URL of the video you want to download: \n>> ")))
                yt = YouTube(input("Enter the URL of the video you want to download: \n>> "))
            else:
                # print("sys arg = ", len(sys.argv), sys.argv[1])
                yt = YouTube("https://www.youtube.com/watch?v=AMskvxEWf0k")
        except Exception as err:
            print(err)

        # extract only audio
        video = yt.streams.filter(only_audio=True).first()

        # check for destination to save file
        print("Enter the destination (leave blank for current directory)")
        # destination = str(input(">> ")) or '.'
        destination = ".\\new_yt_media_dl"

        # download the file
        out_file = video.download(output_path=destination)
        print("YT audio dl only for: ", yt.title)
        # save the file
        base, ext = os.path.splitext(out_file)
        new_file = base + '.mp3'
        os.rename(out_file, new_file)

        # result of success
        print(yt.title + " has been successfully downloaded.")

    def pytube_video_mp4(self):
        pass

if __name__=='__main__':
    x = YouTube_DL()
    # x.check_yt_url()
    x.pytube_mp3_only()
