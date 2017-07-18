TARGETS = mountkernfs.sh hostname.sh udev mountdevsubfs.sh urandom mountall.sh mountall-bootclean.sh hwclock.sh networking checkroot.sh mountnfs.sh mountnfs-bootclean.sh procps bootmisc.sh checkfs.sh checkroot-bootclean.sh kmod udev-finish
INTERACTIVE = udev checkroot.sh checkfs.sh
udev: mountkernfs.sh
mountdevsubfs.sh: mountkernfs.sh udev
urandom: mountall.sh mountall-bootclean.sh hwclock.sh
mountall.sh: checkfs.sh checkroot-bootclean.sh
mountall-bootclean.sh: mountall.sh
hwclock.sh: mountdevsubfs.sh
networking: mountkernfs.sh mountall.sh mountall-bootclean.sh urandom procps
checkroot.sh: hwclock.sh mountdevsubfs.sh hostname.sh
mountnfs.sh: mountall.sh mountall-bootclean.sh networking
mountnfs-bootclean.sh: mountall.sh mountall-bootclean.sh mountnfs.sh
procps: mountkernfs.sh mountall.sh mountall-bootclean.sh udev
bootmisc.sh: mountall.sh mountall-bootclean.sh mountnfs.sh mountnfs-bootclean.sh udev checkroot-bootclean.sh
checkfs.sh: checkroot.sh
checkroot-bootclean.sh: checkroot.sh
kmod: checkroot.sh
udev-finish: udev mountall.sh mountall-bootclean.sh
