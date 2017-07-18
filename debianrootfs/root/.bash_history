ls
distro=jessie
export LANG=C
/debootstrap/debootstrap --second-stage
cat <<EOT > /etc/apt/sources.list
deb http://ftp.uk.debian.org/debian $distro main contrib non-free
deb-src http://ftp.uk.debian.org/debian $distro main contrib non-free
deb http://ftp.uk.debian.org/debian $distro-updates main contrib non-free
deb-src http://ftp.uk.debian.org/debian $distro-updates main contrib non-free
deb http://security.debian.org/debian-security $distro/updates main contrib non-free
deb-src http://security.debian.org/debian-security $distro/updates main contrib non-free
EOT

apt-get update
apt-get install locales dialog
dpkg-reconfigure locales
passwd 
echo <<EOT >> /etc/network/interfaces
allow-hotplug eth0
iface eth0 inet static
address 192.168.1.254
netmask 255.255.255.248
gateway 192.168.1.1
EOT

echo nameme > /etc/hostname
echo T0:2345:respawn:/sbin/getty -L ttyS0 115200 vt100 >> /etc/inittab
 
rm /usr/bin/qemu-x86_64-static 
rm /etc/resolv.conf 
ls
exit
ls
cd
ls
ls
cd /
ls
exit
ls
cd
ls
ls
cd /
ls
cd lib/modprobe.d/
ls
vim aliases.conf 
uname -a
ls
exit
