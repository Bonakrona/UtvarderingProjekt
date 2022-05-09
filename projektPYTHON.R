
source ("https://fileadmin.cs.lth.se/cs/Education/EDAA35/R_resources.R")
plotresult <- function(file, start = 1) {
  data <- read.csv(file)
  data <- data[start:nrow(data),]
  plot(data, type = "l")
}
system("python (SCRIPTNAME.PY) infil.txt utfilPYTHON.txt")
plotresult ("utfilPYTHON.txt") # plot to screen
pdf ("utfilPYTHON.pdf ")
plotresult ("utfilPYTHON.txt") # plot to pdf file
dev.off ()

xhatt <- vector()
confidence <- vector()
means <- vector()

for (index in 1:100){
  system("python (SCRIPTNAME.PY) infil.txt utfilPYTHON.txt")
  plotresult("utfilPYTHON.txt")
  total <- read.csv("utfilPYTHON.txt")
  #newdata <- cbind(newdata, confidenceInterval(total$tid))
  means <- cbind(means, mean(total$tid))
  
  dev.off()
}

xhattPYTHON <- mean(means)
confidencePYTHON <- confidenceInterval(means)
#xhatt_egenSortering <- mean(means)
#confidence_egenSortering <- confidenceInterval(means)