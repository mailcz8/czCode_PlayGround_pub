import paramiko
import configparser
import re

ssh = paramiko.SSHClient()
env_conf = 'my_config.ini'

def connect(hostname=None, port=22, username=None, password=None, command=None):
    ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy)
    x = _load_config('SSH Conf')
    hostname = x['ip']
    port = x['port']
    username = x['username']
    password = x['password']
    command = 'ls -al'

    print(hostname, port, username, password, command)

    ssh.load_system_host_keys()
    ssh.connect(hostname, port, username, password)
    stdin, stdout, stderr = ssh.exec_command(command)
    print(stdin, stdout, stderr)
    ssh.close()

def _load_config(section):
    config = configparser.ConfigParser()
    print(env_conf)
    config.read(env_conf)
    _config = {}
    if config.has_section(section):
        _config.update(dict((key, val) for key, val in config.items(section)))
    else:
        print('Missing config section info!!!')
    return _config

connect()