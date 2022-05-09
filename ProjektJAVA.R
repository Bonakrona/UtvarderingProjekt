
source ("https://fileadmin.cs.lth.se/cs/Education/EDAA35/R_resources.R")
plotresult <- function(file, start = 1) {
  data <- read.csv(file)
  data <- data[start:nrow(data),]
  plot(data, type = "l")
}
system("java mergetest skriv.txt utfilJAVA.txt")
plotresult ("utfilJAVA.txt") # plot to screen
pdf ("utfilJAVA.pdf ")
plotresult ("utfilJAVA.txt") # plot to pdf file
dev.off ()

xhatt <- vector()
confidence <- vector()
means <- vector()

for (index in 1:100){
  system("java mergetest skriv.txt utfilJAVA.txt")
  plotresult("utfilJAVA.txt")
  total <- read.csv("utfilJAVA.txt")
  #newdata <- cbind(newdata, confidenceInterval(total$tid))
  means <- cbind(means, mean(total$tid))
  
  dev.off()
}

xhattJAVA <- mean(means)
confidenceJAVA <- confidenceInterval(means)
#xhatt_egenSortering <- mean(means)
#confidence_egenSortering <- confidenceInterval(means)